let getHtml = ()=>{
    let edit = document.getElementById("editormd");
    let text = edit.getElementsByTagName("textarea")[0];

    let preview = document.getElementsByClassName("markdown-body editormd-preview-container")[0];

    // alert(""+ori);
    // alert(""+html);
    let md = document.getElementById("md");
    let html = document.getElementById("html");

    md.value=text.innerText;
    html.value=preview.innerHTML;
};