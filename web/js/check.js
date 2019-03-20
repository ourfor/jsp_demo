let checkInput =()=>{
    let fileInput = document.getElementsByName("filename");
    fileInput = fileInput[0];
    if(fileInput.value===''){
        alert("请选择提交文件");
        fileInput.click();
        event.preventDefault();
    }
};

let findInput = ()=>{
    let EleInput = document.getElementById("confirm");
    EleInput.onclick = checkInput;
};