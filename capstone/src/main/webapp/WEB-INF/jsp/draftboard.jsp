<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="includes/header.jsp" />

<main>
        <h1 class="text-center mt-3">Draftboard</h1>
        
        <form action="/draftboardSubmit" method="POST">
        <div class="mb-3 pr-5 d-flex align-items-right justify-content-center" id="selection">
            <label for="playerId" class="form-label mx-2">Select Your Player</label>
            <select class="form-select playerId" id="playerId" style="width:50%" name="playerId">
            <c:forEach items="${players}" var="player">
                <option value="${player.id}"
                    <c:if test="${player.id eq form.playerId}">
                        selected
                    </c:if>
                >${player.name}</option>
            </c:forEach>
            </select>
            <c:if test="${bindingResult.hasFieldErrors('playerId')}">
                                <c:forEach items="${bindingResult.getFieldErrors('playerId')}" var="error">
                                    <div style="color:white">${error.getDefaultMessage()}</div>
                                </c:forEach>
                              </c:if>
        </div>
            <div class="mx-3">
            <input type="hidden" name="id" value="${form.id}"/>
            </div>
             <c:if test="${success}">
                            <div class="alert alert-success" role="alert">
                                Draft Pick Created
                            </div>
                        </c:if>
            <div class="mb-4 pr-5 d-flex align-items-right justify-content-center">
               <label for="teamId" class="form-label mx-3">Select Your Team</label>
                 <select class="form-select" style="width:50%" id="teamId" name="teamId">
                   <c:forEach items="${teams}" var="team">
                     <option value="${team.id}"
                       <c:if test="${team.id eq form.teamId}">
                         selected
                       </c:if>
                     >${team.teamName}</option>
                   </c:forEach>
                 </select>
                 <c:if test="${bindingResult.hasFieldErrors('teamId')}">
                                     <c:forEach items="${bindingResult.getFieldErrors('teamId')}" var="error">
                                         <div style="color:white">${error.getDefaultMessage()}</div>
                                     </c:forEach>
                                   </c:if>
            </div>
                <div class="mb-4 pr-5 d-flex align-items-right justify-content-center">
                  <label for="draftPickNumber" class="form-label mx-3">Select Draft Pick</label>
                  <input type="number" class="form-control" style="width:50%" id="draftPickNumber" name="draftPickNumber"
                  aria-describedby="draftPickHelp" value="${form.draftPickNumber}">
            <c:if test="${bindingResult.hasFieldErrors('draftPickNumber')}">
                                <c:forEach items="${bindingResult.getFieldErrors('draftPickNumber')}" var="error">
                                    <div style="color:white">${error.getDefaultMessage()}</div>
                                </c:forEach>
                              </c:if>
                </div>
                <div class="text-center">
                    <button type="submit" class="mb-3 btn btn-primary" id="draft_btn">Draft Player</button>
                </div>
            </form>
        <section class="py-5 bg-dark-grey">
            <div class="container text-center">
            <h4 class="pb-2">Draft Results</h4>

            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                    <th scope="col">Round #</th>
                    <c:forEach items="${teams}" var="team">
                        <th scope="col"><a href="team/detail/${team.id}">${team.teamName}</a></th>
                    </c:forEach>
                    <!-- <th scope="col" id="team1"><a href="team/detail/">Team 1</th>
                    <th scope="col" id="team2"><a href="team2.html">Team 2</th>
                    <th scope="col" id="team3"><a href="team3.html">Team 3</th>
                    <th scope="col" id="team4"><a href="team4.html">Team 4</th>
                    <th scope="col" id="team5"><a href="team5.html">Team 5</th>
                    <th scope="col" id="team6"><a href="team6.html">Team 6</th>
                    <th scope="col" id="team7"><a href="team7.html">Team 7</th>
                    <th scope="col" id="team8"><a href="team8.html">Team 8</th>
                    <th scope="col" id="team9"><a href="team9.html">Team 9</th>
                    <th scope="col" id="team10"><a href="team10.html">Team 10</th>
                    <th scope="col" id="team11"><a href="team11.html">Team 11</th>
                    <th scope="col" id="team12"><a href="team12.html">Team 12</th> -->
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <c:forEach items="${teamPlayers}" var="players">
                            <c:choose>
                                <c:when test="${players.position eq 'RB'}">
                                    <td style="background-color: aqua;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                                <c:when test="${players.position eq 'WR'}">
                                    <td style="background-color: green;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                                <c:when test="${players.position eq 'TE'}">
                                    <td style="background-color: orange;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                                <c:when test="${players.position eq 'QB'}">
                                    <td style="background-color: red;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                                <c:when test="${players.position eq 'D/ST'}">
                                    <td style="background-color: brown;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                                <c:when test="${players.position eq 'K'}">
                                    <td style="background-color: pink;"><a href="/player/detail/${players.id}">${players.name}</a><br />
                                        ${players.position}<br />
                                        ${players.team}<br />
                                        Bye: ${players.bye}</td>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                        
                    </tr>
                
                    <tr>
                        <th scope="row">2</th>
                        <td id="pick25">24</td>
                        <td id="pick26">23</td>
                        <td id="pick27">22</td>
                        <td id="pick28">21</td>
                        <td id="pick29">20</td>
                        <td id="pick30">19</td>
                        <td id="pick31">18</td>
                        <td id="pick32">17</td>
                        <td id="pick33">16</td>
                        <td id="pick34">15</td>
                        <td id="pick35">14</td>
                        <td id="pick36">13</td>
                    </tr>
                
                    <tr>
                        <th scope="row">3</th>
                        <td id="pick25">25</td>
                        <td id="pick26">26</td>
                        <td id="pick27">27</td>
                        <td id="pick28">28</td>
                        <td id="pick29">29</td>
                        <td id="pick30">30</td>
                        <td id="pick31">31</td>
                        <td id="pick32">32</td>
                        <td id="pick33">33</td>
                        <td id="pick34">34</td>
                        <td id="pick35">35</td>
                        <td id="pick36">36</td>
                    </tr>
                    <tr>
                        <th scope="row">4</th>
                        <td id="pick48">48</td>
                        <td id="pick47">47</td>
                        <td id="pick46">46</td>
                        <td id="pick45">45</td>
                        <td id="pick44">44</td>
                        <td id="pick43">43</td>
                        <td id="pick42">42</td>
                        <td id="pick41">41</td>
                        <td id="pick40">40</td>
                        <td id="pick39">39</td>
                        <td id="pick38">38</td>
                        <td id="pick37">37</td>
                    </tr>
                    <tr>
                        <th scope="row">5</th>
                        <td id="pick49">49</td>
                        <td id="pick50">50</td>
                        <td id="pick51">51</td>
                        <td id="pick52">52</td>
                        <td id="pick53">53</td>
                        <td id="pick54">54</td>
                        <td id="pick55">55</td>
                        <td id="pick56">56</td>
                        <td id="pick57">57</td>
                        <td id="pick58">58</td>
                        <td id="pick59">59</td>
                        <td id="pick60">60</td>
                    </tr>
                    <tr>
                        <th scope="row">6</th>
                        <td id="pick72">72</td>
                        <td id="pick71">71</td>
                        <td id="pick70">70</td>
                        <td id="pick69">69</td>
                        <td id="pick68">68</td>
                        <td id="pick67">67</td>
                        <td id="pick66">66</td>
                        <td id="pick65">65</td>
                        <td id="pick64">64</td>
                        <td id="pick63">63</td>
                        <td id="pick62">62</td>
                        <td id="pick61">61</td>
                    </tr>
                    <tr>
                        <th scope="row">7</th>
                        <td id="pick73">73</td>
                        <td id="pick74">74</td>
                        <td id="pick75">75</td>
                        <td id="pick76">76</td>
                        <td id="pick77">77</td>
                        <td id="pick78">78</td>
                        <td id="pick79">79</td>
                        <td id="pick80">80</td>
                        <td id="pick81">81</td>
                        <td id="pick82">82</td>
                        <td id="pick83">83</td>
                        <td id="pick84">84</td>
                    </tr>
                    <tr>
                        <th scope="row">8</th>
                        <td id="pick96">96</td>
                        <td id="pick95">95</td>
                        <td id="pick94">94</td>
                        <td id="pick93">93</td>
                        <td id="pick92">92</td>
                        <td id="pick91">91</td>
                        <td id="pick90">90</td>
                        <td id="pick89">89</td>
                        <td id="pick88">88</td>
                        <td id="pick87">87</td>
                        <td id="pick86">86</td>
                        <td id="pick85">85</td>
                    </tr>
                    <tr>
                        <th scope="row">9</th>
                        <td id="pick97">97</td>
                        <td id="pick98">98</td>
                        <td id="pick99">99</td>
                        <td id="pick100">100</td>
                        <td id="pick101">101</td>
                        <td id="pick102">102</td>
                        <td id="pick103">103</td>
                        <td id="pick104">104</td>
                        <td id="pick105">105</td>
                        <td id="pick106">106</td>
                        <td id="pick107">107</td>
                        <td id="pick108">108</td>
                    </tr>
                    <tr>
                        <th scope="row">10</th>
                        <td id="pick120">120</td>
                        <td id="pick119">119</td>
                        <td id="pick118">118</td>
                        <td id="pick117">117</td>
                        <td id="pick116">116</td>
                        <td id="pick115">115</td>
                        <td id="pick114">114</td>
                        <td id="pick113">113</td>
                        <td id="pick112">112</td>
                        <td id="pick111">111</td>
                        <td id="pick110">110</td>
                        <td id="pick109">109</td>
                    </tr>
                    <tr>
                        <th scope="row">11</th>
                        <td id="pick121">121</td>
                        <td id="pick122">122</td>
                        <td id="pick123">123</td>
                        <td id="pick124">124</td>
                        <td id="pick125">125</td>
                        <td id="pick126">126</td>
                        <td id="pick127">127</td>
                        <td id="pick128">128</td>
                        <td id="pick129">129</td>
                        <td id="pick130">130</td>
                        <td id="pick131">131</td>
                        <td id="pick132">132</td>
                    </tr>
                    <tr>
                        <th scope="row">12</th>
                        <td id="pick144">144</td>
                        <td id="pick143">143</td>
                        <td id="pick142">142</td>
                        <td id="pick141">141</td>
                        <td id="pick140">140</td>
                        <td id="pick139">139</td>
                        <td id="pick138">138</td>
                        <td id="pick137">137</td>
                        <td id="pick136">136</td>
                        <td id="pick135">135</td>
                        <td id="pick134">134</td>
                        <td id="pick133">133</td>
                    </tr>
                    <tr>
                        <th scope="row">13</th>
                        <td id="pick145">145</td>
                        <td id="pick146">146</td>
                        <td id="pick147">147</td>
                        <td id="pick148">148</td>
                        <td id="pick149">149</td>
                        <td id="pick150">150</td>
                        <td id="pick151">151</td>
                        <td id="pick152">152</td>
                        <td id="pick153">153</td>
                        <td id="pick154">154</td>
                        <td id="pick155">155</td>
                        <td id="pick156">156</td>
                    </tr>
                    <tr>
                        <th scope="row">14</th>
                        <td id="pick168">168</td>
                        <td id="pick167">167</td>
                        <td id="pick166">166</td>
                        <td id="pick165">165</td>
                        <td id="pick164">164</td>
                        <td id="pick163">163</td>
                        <td id="pick162">162</td>
                        <td id="pick161">161</td>
                        <td id="pick160">160</td>
                        <td id="pick159">159</td>
                        <td id="pick158">158</td>
                        <td id="pick157">157</td>
                    </tr>
                </tbody>
            </table>

            <table class="table table-striped border">
                <thead>
                <tr>
                    <th scope="col">Pick Number</th>
                    <th scope="col">Name</th>
                    <th scope="col">Position</th>
                    <th scope="col">Team</th>
                    <th scope="col">Bye</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${teamPlayers}" var="players">
                <tr>
                    <td>${players.draft_pick_number}</td>
                    <td><a href="/player/detail/${players.id}">${players.name}</a></td>
                    <td>${players.position}</td>
                    <td>${players.team}</td>
                    <td>${players.bye}</td>
                </tr>
            </c:forEach>
            </tbody>
            </table>
        </div>
        </section>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
    <script src="../../pub/js/script.js"></script>

<jsp:include page="includes/footer.jsp" />