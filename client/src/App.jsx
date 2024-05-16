 import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
 // src/index.js
import './index.css';

import Home from "./pages/Home";
import Status from "./pages/Status";
import StateViewer from "./pages/StateViewer";
import Signin from "./pages/Signin";
function App() {


  return (
    <>
       <Router>
         <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/status" element={<Status/>}/>
          <Route path="/status/:usreId" element={<StateViewer/>}/>
          <Route path="/signin" element={<Signin/>}/>
         </Routes>
       </Router>
    </>
  )
}

export default App
