import React, { useEffect, useState } from "react";
import personService from "../service/person.service";
import { Link } from "react-router-dom";

const Home = () => {
  const [list, setList] = useState([]);
  const [msg, setMsg] = useState("");

  useEffect(() => {
    loadData();
  }, []);

  const loadData = () => {
    personService.getAllPerson().then((res) => {
      setList(res.data);
    });
  };

  const deletePerson = (id) => {
    if (!window.confirm("Are you sure?")) return;

    personService.deletePerson(id).then(() => {
      setMsg("Deleted Successfully");
      loadData(); // refresh
    });
  };

  return (
    <div className="container mt-3">
      <div className="card">
        <div className="card-header text-center fs-3">Person List</div>

        {msg && <p className="text-success text-center">{msg}</p>}

        <div className="card-body">
          <table className="table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Action</th>
              </tr>
            </thead>

            <tbody>
              {list.map((p) => (
                <tr key={p.id}>
                  <td>{p.id}</td>
                  <td>{p.name}</td>
                  <td>{p.email}</td>
                  <td>
                    <Link
                      to={`/edit/${p.id}`}
                      className="btn btn-primary btn-sm me-2"
                    >
                      Edit
                    </Link>

                    <button
                      className="btn btn-danger btn-sm"
                      onClick={() => deletePerson(p.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Home;
