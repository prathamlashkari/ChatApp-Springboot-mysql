 import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
 // src/index.js
import './index.css';

import Home from "./pages/Home";
import Status from "./pages/Status";
import StateViewer from "./pages/StateViewer";
function App() {


  return (
    <>
       <Router>
         <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/status" element={<Status/>}/>
          <Route path="/status/:usreId" element={<StateViewer/>}/>
         </Routes>
       </Router>
    </>
  )
}

export default App
