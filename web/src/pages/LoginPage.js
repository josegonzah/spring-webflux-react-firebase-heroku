import React, {Fragment, useState} from 'react';
import { Link } from 'react-router-dom'
import firebase from "firebase/app";
import "firebase/firestore";
import "firebase/auth";
import swal from 'sweetalert';
import { login } from '../actions/authActions';
import { useAuthState } from 'react-firebase-hooks/auth';
import {SignIn} from '../App'

firebase.initializeApp({
    apiKey: "AIzaSyCF3k_a8SCqMyCJ5EWv00iux_X3ezHyEOQ",
    authDomain: "question-answer-sofkau.firebaseapp.com",
    projectId: "question-answer-sofkau",
    storageBucket: "question-answer-sofkau.appspot.com",
    messagingSenderId: "914875973566",
    appId: "1:914875973566:web:96cc9d8c1940f7bce6c3ef",
    measurementId: "G-LQPB17D6T4"
  });

  const auth = firebase.auth();

  const LoginPage = ({ dispatch}) =>{
      const [userInfo, setUserInfo] = useState({
          name: '',
          password: ''
      })

      const updateUserInfo = (e) => {
          setUserInfo({
              ...userInfo,
              [e.target.name] : e.target.value
          })
      }

      const login = (e) => {
          e.preventDefault()
          return auth.signInWithEmailAndPassword(userInfo.name, userInfo.password)
            .then(() => {
                swal('Loguedo')
            })
            .catch(() => {
                swal({
                    icon: 'error',
                    title: 'Error',
                    text: 'Username o password no aceptados'
                })
            })
      }

      const [user] = useAuthState(auth);
      if(user){
          dispatch(login(user.email, user.uid))
      }

      return <section>
          <div>
            <div className="wrapper fadeInDown">
                <div id="form-content">
                    <h3>Log in</h3>
                    <form onSubmit={login}>
                        <input type="text" id="login" className="fadeIn second" name="name" placeholder="Email address" value={userInfo.name} onChange={updateUserInfo}/>
                        <input type="text" id="password" className="fadeIn third" name="password" placeholder="password" value={userInfo.password} onChange={updateUserInfo} />
                        <input type="submit" className="fadeIn fourth" value="Log In" />
                        <input type="password" id="password" className="fadeIn third" name="password" placeholder="password" value={userInfo.password} onChange={updateUserInfo} />
                        <input type="submit" className="fadeIn fourth button" value="Log In" />
                    </form>

                </div>
              </div>
              {SignIn()}
              <Link to="/register">Registro</Link>
          </div>
      </section>
  }

  export default LoginPage;