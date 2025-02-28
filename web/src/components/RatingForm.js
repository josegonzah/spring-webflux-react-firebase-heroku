import React from 'react';
import {connect} from 'react-redux';
import {postRating} from "../actions/questionActions";

import { useForm } from "react-hook-form";
import Rating from "./Rating";

function RatingForm({ question, user, dispatch, loading, hasErrors }) {
  const { register, handleSubmit } = useForm();

  const onSubmit = (data) => {
    dispatch(postRating(data.review, question.id, user));
  };

  const renderQuestions = () => {
    console.log(question)
    return question.rates.includes(user);
  };
  if (loading) return <p>Loading ...</p>;
  if (hasErrors) return <p>Unable to display questions.</p>;

  return (
    <section>
      <h1>Questions</h1>
      {renderQuestions() ? (
        <div>
          Average question rating: <Rating question={question} />
        </div>
      ) : (
        <form onSubmit={handleSubmit(onSubmit)}>
          <label for="review">Question rating</label>
          <select {...register("review")} id="" required>
            <option value=""> Select...</option>
            <option value="1">{`\u{1f641}`}</option>
            <option value="2"> {`\u{1f610}`}</option>
            <option value="3"> {`\u{1f600}`}</option>
          </select>
          <button type="submit" className="button" style={{display: 'block'}}>
            Send review
          </button>
        </form>
      )}
    </section>
  );
}

const mapStateToProps = (state) => ({
  loading: state.question.loading,
  hasErrors: state.question.hasErrors,
  question: state.question.question,
  user: state.auth.uid,
});

export default connect(mapStateToProps)(RatingForm); 