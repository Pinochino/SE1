import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function HomePage() {
    const [students, setStudents] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const API = `http://localhost:8080/api/v1/students/list`;
        axios
            .get(API)
            .then((res) => {
                setLoading(false);
                setStudents(res.data);
            })
            .then((error) => {
                setLoading(false);
                setError(error);
            });
    }, []);

    if (error) {
        return <h1>The website have {error}</h1>;
    }

    if (loading) {
        return <h1>The website have been loading</h1>;
    }

    const handleDelete = async (studentId) => {
        const API = `http://localhost:8080/api/v1/students/delete/${studentId}`
        try {
            await axios.delete(API)
            setStudents((prev) => prev.filter((student) => student.id !== studentId));
        } catch (error) {
            setError(`Failed to delete student with id ${studentId}`);
        }
    }


    return (
        <div className="container">
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Student id</th>
                        <th scope="col">Student Name</th>
                        <th scope="col">Student Age</th>
                        <th scope="col text-center" colSpan={2}>Handle</th>
                    </tr>
                </thead>
                <tbody>
                    {students.map((student, index) => (
                        <tr key={index}>
                            <th scope="row">{student.id}</th>
                            <td>{student.name}</td>
                            <td>{student.age}</td>
                            <td>
                                <Link to={`http://localhost:8080/api/v1/students/update/${student.id}`} className="btn btn-outline-primary me-3">Update</Link>
                                <button onClick={() => handleDelete(student.id)} className="btn btn-outline-danger">Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default HomePage;
