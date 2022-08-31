window.onload=function (){
    let img = document.getElementById("checkCode");
    img.onclick=function (){
        let time = new Date().getTime();
        img.src="/CheckCode?"+time;
    }
}
function chang(){
    let img = document.getElementById("checkCode");
    let time = new Date().getTime();
    img.src="/CheckCode?"+time;
}