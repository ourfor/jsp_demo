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

let inputNum = ()=>{
    let str = findName('age');
    let isLegal = true;
    let age =document.getElementById("age");
    age.style.color="red";
    age.style.fontSize="0.8em";
    age.paddingLeft="2px";
    for(let i=0;i<str.length;i++){
        age.innerText="";
        if(!str[i].match('[0-9]')) {
            isLegal = false;
            age.innerText="请输入合法年龄";
            break;
        }
    }
    if(str==='') {
        age.innerText="\0\0没有填写年龄";
        isLegal=false;
    }
    else{
        age.innerText="";
    }

    if(!isLegal) event.preventDefault();
};

let findName = (str)=>{
    let target = document.getElementsByName(str);
    target = target[0];
    return target.value.toString();
};

let fillInput = ()=>{
    inputNum();
    let input = document.getElementsByTagName("<input>");
    let isLegal = true;
    for(let i=0;i<input.length;i++) isLegal=isLegal&&!(input[i].value === '');
    isLegal = isLegal&&checkHobby();
    if(isLegal===false) {
        alert("还有一些信息没有填写");
        event.preventDefault();
    }
    checkUserName();
};

let checkHobby = ()=>{
    let isLegal = false;
    let hobby = document.getElementsByName("interest");
    for(let i=0;i<hobby.length;i++){
        isLegal = isLegal ||(hobby[i].checked === true);
    }
    return isLegal;
};

let checkUserName = ()=>{
    let username = document.getElementsByName("username");
    let info = document.getElementById("user");
    username = username[0];
    if(username.value === ""){
        info.innerText = "\0\0非法用户名";
        info.style.color="red";
        info.style.fontSize="0.8em";
        info.paddingLeft="2px";
        event.preventDefault();
    }
    else info.innerText="";
};