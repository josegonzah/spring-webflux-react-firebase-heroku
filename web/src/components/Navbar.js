import React from 'react'
import { Link } from 'react-router-dom'
import logo from '../media/questionlogo.jpg';

export const PublicNavbar = () => (
  <nav>
    <Link to="/"><img src={logo} alt='Icon' style={{marginLeft: "2rem", height: "2.5rem"}}/></Link>
    <section>
      <Link to="/">Home</Link>
      <Link to="/questions">Questions</Link>
      <Link to="/login"><button className="button right">Log in</button></Link>
    </section>
  </nav>
)

export const PrivateNavbar = ({SignOut, dispatch}) => (
  <nav>
    <img src={logo} alt='Logo' style={{marginLeft:"2rem", height: "3.5rem"}}/>
    <section>
      <Link to="/">Home</Link>
      <Link to="/questions">Questions</Link>
      <Link to="/login"><button className="button right">Log in</button></Link>
      <Link to="/new">New</Link>
      <Link to="/list">List</Link>
    </section>
    <Link to="/">
      <SignOut dispatch={dispatch}></SignOut>
    </Link>
  </nav>
)
