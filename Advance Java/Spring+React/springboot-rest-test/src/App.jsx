import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./component/Home";
import AddPerson from "./component/AddPerson";
import EditPerson from "./component/EditPerson";
import Navbar from "./component/Navbar";

function App() {
  return (
    <BrowserRouter>
      <Navbar />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/add" element={<AddPerson />} />
        <Route path="/edit/:id" element={<EditPerson />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;