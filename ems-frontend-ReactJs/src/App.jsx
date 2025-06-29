import './App.css'
import EmployeeAddComponent from './components/EmployeeAddComponent'
import FooterComponent from './components/FooterComponent'
//import HeaderComponent from './components/HeaderComponent'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import {BrowserRouter,Route,Routes} from 'react-router-dom'
function App() {
  

  return (
    <>
    <BrowserRouter>
        <HeaderComponent/>
        <Routes>
          {/* //http://localhost//:3000 */}

            <Route path='/' element={<ListEmployeeComponent/>}></Route>
            {/* //http://localhost//:3000/employees */}
            <Route path='/employees' element={<ListEmployeeComponent/>}></Route>
            {/* //http://localhost//:3000/add-employee */}
            <Route path='/add-employee' element={<EmployeeAddComponent/>}></Route>
            {/* //http://localhost//:3000/edit-employee/1 */}
            <Route path='/edit-employee/:id' element={<EmployeeAddComponent/>}></Route>
        </Routes>

        <FooterComponent/>
    </BrowserRouter>

    </>
  )
}

export default App
