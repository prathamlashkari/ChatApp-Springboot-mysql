 import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
 // src/index.js
import './index.css';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';



import Home from "./pages/Home";
import Status from "./pages/Status";
import StateViewer from "./pages/StateViewer";
import Signin from "./pages/Signin";
import SignUp from "./pages/SignUp";
function App() {


  return (
    <>
       <Router>
         <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/status" element={<Status/>}/>
          <Route path="/status/:usreId" element={<StateViewer/>}/>
          <Route path="/signin" element={<Signin/>}/>
          <Route path="/signup" element={<SignUp/>}/>
         </Routes>
       </Router>
       <ToastContainer/>
    </>
  )
}

export default App
