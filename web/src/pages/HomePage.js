import React from 'react'
import { Link } from 'react-router-dom'
import Footer from '../components/Footer'

const HomePage = ({children}) => (
  <section>
    <h1>Home</h1>
    <div>
      {children}
    </div>
    <p>welcome to the question and answer app.</p>
    <Link to="/questions" className="button">
      View Questions
    </Link>
  <Footer></Footer>
  </section>
)
export default HomePage
