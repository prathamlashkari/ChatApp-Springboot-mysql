 import { BrowserRouter as Router , Routes , Route } from "react-router-dom"
 // src/index.js
import './index.css';

import Home from "./Component/Home"
import Profile from "./Component/Profile";
function App() {


  return (
    <>
       <Router>
         <Routes>
          <Route path="/" element={<Home/>}/>
          {/* <Route path="/profile" element={<Profile/>}/> */}
         </Routes>
       </Router>
    </>
  )
}

export default App
