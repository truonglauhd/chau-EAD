import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  
  const [data, setData] = useState([]);

  useEffect(() => {
    loadData();
  }, []);

  const loadData = async () => {
    try {
      const res = await axios.get("http://localhost:8080/students/table");
      setData(res.data);
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Student Score Table</h2>

      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Subject</th>
            <th>Score 1</th>
            <th>Score 2</th>
            <th>Credit</th>
            <th>Grade</th>
            <th>Letter</th>
          </tr>
        </thead>

        <tbody>
          {data.map((item, index) => (
            <tr key={index}>
              <td>{item.studentId}</td>
              <td>{item.studentName}</td>
              <td>{item.subjectName}</td>
              <td>{item.score1}</td>
              <td>{item.score2}</td>
              <td>{item.credit}</td>
              <td>{item.grade.toFixed(2)}</td>
              <td>{item.letterGrade}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;