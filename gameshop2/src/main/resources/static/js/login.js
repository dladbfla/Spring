const urlLogin = "http://localhost:8080/user/login";
let userId = "";
let password = "";

document.querySelector("#userId").addEventListener("change",(e)=>{
    console.log(e.target.value);
    userId = e.target.value;
})
document.querySelector("#password").addEventListener("change",(e)=>{
    console.log(e.target.value);
    password = e.target.value;
})
document.querySelector(".loginBtn").addEventListener("click",(e)=>{
    const data = {
        userId: userId,
        password: password
    }
    axios
    .post(urlLogin, data, {withCredentials:true})
    .then((Response)=>{
        console.log("데이터: ", Response);
    })
    .catch((error)=>{
        console.log("에러 발생: ", error);
    })
})