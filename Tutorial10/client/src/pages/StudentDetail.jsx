import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function StudentDetail() {

    const [student, setStudent] = useState();
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true);

    const { studentId } = useParams();

    useEffect(() => {
        const API = ` http://localhost:8080/api/v1/students/detail/${studentId}`;
        axios.get(API)
            .then(res => {
                setLoading(false)
                setStudent(res)
            })
            .catch(error => {
                setLoading(false)
                setError(error)
            })
    }, [studentId])

    if (error) {
        return <h2>This website have {error}</h2>
    }

    if (loading) {
        return <h3>This website have been loading</h3>
    }

    return (<div className="container">
        <h3>Detail Student</h3>
        <p>Student ID: {student.id}</p>
        <p>Student Name: {student.name}</p>
        <p>Student Age: {student.age}</p>
    </div>);
}

export default StudentDetail;