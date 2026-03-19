import React, { useState } from "react";
import personService from "../service/person.service";

const AddPerson = () => {
  const [person, setPerson] = useState({
    name: "",
    email: "",
  });

  const [msg, setMsg] = useState("");

  const handleChange = (e) => {
    setPerson({ ...person, [e.target.name]: e.target.value });
  };

  const submitPerson = (e) => {
    e.preventDefault();

    personService
      .savePerson(person)
      .then(() => {
        setMsg("Person Added Sucessfully ");
        setPerson({ name: "", email: "" });
      })
      .catch((error) => console.log(error));
  };

  return (
    <div className="container">
      <div className="card">
        <div className="card-header text-center fs-3">Add Person</div>

        {msg && <p className="text-sucess text-center">{msg}</p>}

        <div className="card-body">
          <form onSubmit={submitPerson}>
            <input
              type="text"
              name="name"
              placeholder="Enter Name"
              className="form-control mb-3"
              value={person.name}
              onChange={handleChange}
            />

            <input
              type="email"
              name="email"
              placeholder="Enter Email"
              className="form-control mb-3"
              value={person.email}
              onChange={handleChange}
            />

            <button className="btn btn-primary w-100">
              Submit
            </button>

          </form>
        </div>
      </div>
    </div>
  );
};

export default AddPerson;
