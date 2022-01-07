import React from 'react'
import { Link } from 'react-router-dom'
import logo from '../media/questionlogo.jpg';

export const PublicNavbar = () => (
  <nav>
    <img src={logo} alt='Logo' style={{marginLeft:"2rem", height: "3.5rem"}}/>
    <section>
      <Link to="/">Home</Link>
      <Link to="/questions">Questions</Link>
    </section>
  </nav>
)

export const PrivateNavbar = () => (
  <nav>
    <img src={logo} alt='Logo' style={{marginLeft:"2rem", height: "3.5rem"}}/>
    <section>
      <Link to="/">Home</Link>
      <Link to="/questions">Questions</Link>
      <Link to="/new">New</Link>
      <Link to="/list">List</Link>
    </section>
  </nav>
)
