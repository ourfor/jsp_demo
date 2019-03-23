let upload = document.getElementById("upload");
let openFileDialog = ()=>{
    let filename = document.getElementsByName("filename");
    filename=filename[0];
    filename.click();
};

upload.onclick=openFileDialog;

let ShowMenu = ()=>{
    let fileInput = document.getElementsByName("filename");
    let confirm = document.getElementById("confirm");
    let reset = document.getElementById("reset");
    fileInput = fileInput[0];
    if(fileInput.value==="") {
        confirm.style.visibility="hidden";
        reset.style.visibility="hidden";
    }
    else{
        confirm.style.visibility="visible";
        reset.style.visibility="visible";

    }
};

function ShowFileInfo(){
    let filename = document.getElementsByName("filename");
    filename = filename[0];
    let FileInfo = document.getElementsByClassName("FileInfo");
    FileInfo = FileInfo[0];
    if(filename.value==='') FileInfo.innerText="未选择任何文件";
    else FileInfo.innerText=filename.value;
}

let ChangeAction = ()=>{
    alert("执行事件中");
    ShowMenu();
    ShowFileInfo();
};

let filename = document.getElementsByName("filename");
filename = filename[0];
filename.onrowenter=ChangeAction;
