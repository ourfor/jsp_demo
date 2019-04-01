let Forward = ()=>{
    let Element = event.target;
    window.location.href=Element.getAttribute("href");
};

let Find = ()=>{
    let social = document.getElementsByName("list");
    social = social[0];
    let items = social.getElementsByTagName("img");
    for(let i=0;i<items.length;i++) {
        items[i].onclick=Forward;
    }

};