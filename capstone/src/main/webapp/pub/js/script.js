const highlightBtn = document.querySelector("#highlight");
let playerName = document.querySelector("#playerName");

async function onPlayerReady (event) {
    let result = await event.target.playVideo();
    return result;
}

const getVideo = function () {
    let draftedPlayer = playerName.innerHTML;
    console.log(draftedPlayer);
    let playerData = $.ajax({
        type: 'GET',
        url: 'https://www.googleapis.com/youtube/v3/search',
        data: {
            key: "",
            q: draftedPlayer + 'highlights',
            part: 'snippet',
            maxResults: 1,
            type: 'video',
            videoEmbeddable: true,
        },
        success: function(data) {
            // code to open in embedded iframe
            let video = $('iframe').attr('src', 'https://www.youtube.com/embed/' + data.items[0].id.videoId);
            // code to open in new window
            // window.open('https:www.youtube.com/watch?v=' + data.items[0].id.videoId, '_blank');
            return new Promise((resolve) => {
                setTimeout(() => {
                    resolve(video);
                }, 3000);
            });
        },
        error: function(response){
            console.log('Response Failed');
        }
    });

    return new Promise((resolve) => {
        setTimeout(() => {
            resolve(playerData);
        }, 3000);
    });
    //remove player from list after drafted
    // removeDraftedPlayer(draftedPlayer);
};

highlightBtn.addEventListener("click", getVideo);