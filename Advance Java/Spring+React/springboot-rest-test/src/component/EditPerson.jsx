import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import personService from "../service/person.service";

const EditPerson = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const [person, setPerson] = useState({
    name: "",
    email: "",
  });

  useEffect(() => {
    personService.getPersonById(id).then((res) => {
      setPerson(res.data);
    });
  }, [id]);

  const handleChange = (e) => {
    setPerson({ ...person, [e.target.name]: e.target.value });
  };

  const update = (e) => {
    e.preventDefault();

    personService.updatePerson(id, person).then(() => {
      navigate("/");
    });
  };

  return (
    <div className="container mt-3">
      <div className="card">
        <div className="card-header text-center fs-3">Edit Person</div>

        <div className="card-body">
          <form onSubmit={update}>
            <input
              type="text"
              name="name"
              className="form-control mb-3"
              value={person.name}
              onChange={handleChange}
            />

            <input
              type="email"
              name="email"
              className="form-control mb-3"
              value={person.email}
              onChange={handleChange}
            />

            <button className="btn btn-success w-100">Update</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default EditPerson;
