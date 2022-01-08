import React, { useEffect } from 'react'
import { connect } from 'react-redux'

import { fetchQuestions } from '../actions/questionActions'
import { Question } from '../components/Question'
import Footer from '../components/Footer'
import { useState } from 'react';
import { Link } from 'react-router-dom'

const QuestionsPage = ({ dispatch, loading, questions, hasErrors }) => {
    useEffect(() => {
        dispatch(fetchQuestions())
    }, [dispatch])

    const [search, setSearch] = useState('');
    const [categorySearch, setCategorySearch] = useState('');
    const [goTo, setGoTo] = useState('');

    const handleSearch = (e) =>{
        setSearch(e.target.value);
        setGoTo(questionsFilteredSearch[0].id)
    }

    const goToQuestion = (e) =>{
        e.preventDefault()
    }

    const questionsFilteredCategory = questions.filter(question => question.category.toUpperCase().includes(categorySearch.toUpperCase()));

    const questionsFilteredSearch = questionsFilteredCategory.filter(question => question.question.toUpperCase().includes(search.toUpperCase()))

    
    const renderQuestions = () => {
        if (loading) return <p>Loading questions...</p>
        if (hasErrors) return <p>Unable to display questions.</p>

        return questionsFilteredSearch.map(question => <Question setCategorySearch={setCategorySearch} 
            key={question.id} 
            question={question} excerpt />)
    }

    return (
        <section className="page-section">
            <h1>Questions</h1>
            <form onSubmit={goToQuestion}>
                <input type="text" onChange={handleSearch}/>
                <Link class="Link" to={`/question/${goTo}`} ><input type="submit" value="Search" /></Link>
            </form>
            {renderQuestions()}
            <Footer></Footer>
        </section>
    )
}

const mapStateToProps = state => ({
    loading: state.question.loading,
    questions: state.question.questions,
    hasErrors: state.question.hasErrors,
})

export default connect(mapStateToProps)(QuestionsPage)
