import axios from "axios";
import { useState } from "react";
import Notification from "../common/Notification";
import { useNavigate } from "react-router-dom";

function AddStudent() {
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [information, setInformation] = useState({
        name: "",
        age: "",
    });
    const [success, setSuccess] = useState(false);

    const navigate = useNavigate();

    const handleChange = (event) => {

        const { name, value } = event.target;
        setInformation((prev) => ({
            ...prev,
            [name]: value,
        }));
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        setLoading(false);
        setError(null);
        const API = `http://localhost:8080/api/v1/students/add`;
        try {
            const response = await axios.post(API, information);
            console.log("Response:", response.data);
             setSuccess(true);
            setTimeout(() => {
                navigate('/');
            }, 3000)
            setLoading(false);
        } catch (error) {
            console.error("Error:", error);
            setError("Failed to add student. Please try again.");
            setLoading(false);
        }
    };

    if (loading) {
        return <h2>This website have been loading</h2>
    }

    if (error) {
        return <h2>This website have {error}</h2>
    }
    return (
        <div className="container">
            <h3>Add Student</h3>
            {success && <Notification success={true} content={"Successful add"}/>}
            {error && <Notification fail={true} content={"Fail add"}/>}
            <form method="post" onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label for="name" className="form-label">
                        Student Name
                    </label>
                    <input
                        type="text"
                        className="form-control"
                        id="name"
                        autoComplete="additional-name"
                        name="name"
                        value={information.name}
                        onChange={handleChange}
                    />
                </div>
                <div className="mb-3">
                    <label for="age" className="form-label">
                        Age
                    </label>
                    <input
                        type="number"
                        className="form-control"
                        id="age"
                        name="age"
                        value={information.age}
                        onChange={handleChange}
                    />
                </div>
                <button type="submit" className="btn btn-primary">
                    Submit
                </button>
            </form>
        </div>
    );
}

export default AddStudent;
