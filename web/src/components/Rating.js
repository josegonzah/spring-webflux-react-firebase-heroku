import React from "react";

function Rating({ question }) {
  
  const average = Math.round(
    question.sumOfRates / question.numberOfRates
  );
  console.log(average);
  switch (average) {
    case 1:
      return <div>{`\u{1f641}`}</div>;

    case 2:
      return <div>{`\u{1f610}`}</div>;

    case 3:
      return <div>{`\u{1f600}`}</div>;
    default:
      return <div></div>;
  }
}

export default Rating; 