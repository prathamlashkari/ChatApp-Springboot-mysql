 import { BrowserRouter as Router , Routes , Route } from "react-router-dom"
 // src/index.js
import './index.css';

import Home from "./Component/Home"
function App() {


  return (
    <>
       <Router>
         <Routes>
          <Route path="/" element={<Home/>}/>
         </Routes>
       </Router>
    </>
  )
}

export default App
