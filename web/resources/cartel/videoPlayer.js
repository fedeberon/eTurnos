/**
 * Created by Diego on 28/6/2017.
 */

var video_list      = [];
var video_index     = 0;
var video_player    = null;

function onload(){
    getVideoList();
    video_player = document.getElementById("idle_video");
}

function onVideoEnded(){
    console.log("video ended");
    if(video_index < video_list.length - 1){
        video_index++;
    }
    else{
        video_index = 0;
    }
    setVideoSource(video_list[video_index]);
    video_player.play();
}

function setVideoSource(video) {
    video_player.setAttribute("src", video.url);
}

function getVideoList() {
    $.ajax({
            url: "/turnos/restBanner/list",
            success: function(response){
                video_list = response;
                onVideoEnded();
    }});
}

function updateVideoList(videos){
    video_list = videos;
}