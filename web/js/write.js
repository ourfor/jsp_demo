let getHtml = ()=>{
    let edit = document.getElementById("editormd");
    let text = edit.getElementsByTagName("textarea")[0];

    let preview = document.getElementsByClassName("editormd-html-textarea")[0];

    alert(""+text.innerText);
    alert(""+preview.innerText)
    let md = document.getElementById("markdown-doc");
    let html = document.getElementById("html-code");

    md.value=text.innerText;
    html.value=preview.innerText;
};