import React from 'react'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Redirect,
} from 'react-router-dom'
import firebase from "firebase/app";
import "firebase/firestore";
import "firebase/auth";
import { login, logout } from './actions/authActions';

import { PublicNavbar, PrivateNavbar } from './components/Navbar'
import Footer from './components/Footer'
import HomePage from './pages/HomePage'
import SingleQuestionPage from './pages/SingleQuestionPage'
import QuestionsPage from './pages/QuestionsPage'
import QuestionFormPage from './pages/QuestionFormPage'
import AnswerFormPage from './pages/AnswerFormPage'
import OwnerQuestionsPage from './pages/OwnerQuestionsPage'
import { useAuthState } from "react-firebase-hooks/auth";
import LoginPage from './pages/LoginPage'
import RegisterPage from './pages/RegisterPage'


const auth = firebase.auth();

const App = ({ dispatch }) => {
  const [user] = useAuthState(auth);

  if(user){
    dispatch(login(user.email, user.uid))
  }

  return (
    <Router>
      {user ?
        <>
          <PrivateNavbar SignOut={SignOut} dispatch={dispatch}/>
          <Switch>
            <Route exact path="/" component={() => {
              return <HomePage><SignOut dispatch={dispatch} /></HomePage>
            }} />
            <Route exact path="/questions" component={QuestionsPage} />
            <Route exact path="/question/:id" component={SingleQuestionPage} />
            <Route exact path="/list" component={OwnerQuestionsPage} />
            <Route exact path="/answer/:id" component={AnswerFormPage} />
            <Route exact path="/new" component={QuestionFormPage} />
            <Redirect to="/" />
          </Switch>
        </> :
        <>
          <PublicNavbar />
          <Switch>
            <Route exact path="/" component={() => {
              return <HomePage><SignIn dispatch={dispatch} /></HomePage>
            }} />
            <Route exact path="/questions" component={QuestionsPage} />
            <Route exact path="/question/:id" component={SingleQuestionPage} />
            <Route exact path="/answer/:id" component={AnswerFormPage} />
            <Route exact path="/login" component={()=>{
              return <LoginPage dispatch={dispatch} />
            }} />
            <Route exact path="/register" component={()=>{
              return <RegisterPage dispatch={dispatch} />
            }} />
            <Redirect to="/" />
          </Switch>
          <Footer></Footer>
        </>
      }
    </Router>
  )
}


function SignIn() {
  const signInWithGoogle = () => {
    const provider = new firebase.auth.GoogleAuthProvider();
    auth.signInWithPopup(provider);
  };
  return <button className="button" style={{display: 'block', width: '100%'}} onClick={signInWithGoogle}>Sign in with google</button>;;
}

function SignOut({ dispatch }) {
  return (
    auth.currentUser && (
      <button
        className="button right"
        onClick={() => {
          dispatch(logout())
          auth.signOut();
        }}
      >
        Sign out
      </button>
    )
  );
}


export default App
export {SignIn}