import React, {Fragment, useState} from 'react';

import firebase from "firebase/app";
import "firebase/firestore";
import "firebase/auth";
import { login } from '../actions/authActions';
import swal from 'sweetalert';
import { useAuthState } from 'react-firebase-hooks/auth';

const auth = firebase.auth();

const RegisterPage = ({dispatch})=>{

    const [userInfo, setUserInfo] = useState({
        name: '',
        password: ''
    })

    const updateInfo = (e) => {
        setUserInfo({
            ...userInfo,
            [e.target.name] : e.target.value
        })
    }

    const register = (e)=>{
        e.preventDefault()
        return auth.createUserWithEmailAndPassword(userInfo.name, userInfo.password)
    }

    const [user] = useAuthState(auth);
    if(user){
        dispatch(login(user.email, user.uid))
    }

    return <Fragment>
        <div style={{
            maxWidth: '60%',
            textAlign: 'center',
            margin: '2rem auto 2rem auto',
            minHeight: '70vh'
        }}>
                <div className="wrapper fadeInDown">
                    <div id="formContent">

                        <div className="fadeIn first">
                            <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
                        </div>

                        <h2>register</h2>

                        <form onSubmit={register}>
                            <input type="text" id="login" className="fadeIn second" name="name" placeholder="Email" value={userInfo.name} onChange={updateInfo}/>
                            <input type="password" id="password" className="fadeIn third" name="password" placeholder="password" value={userInfo.password} onChange={updateInfo} />
                            <input type="submit" className="fadeIn fourth button" value="Resgister" />
                        </form>

                        <div id="formFooter">
                            <a className="underlineHover" href="#">Olvidaste la contraseña?</a>
                        </div>

                    </div>
                </div>
            </div>
            </Fragment>
}



export default RegisterPage; 