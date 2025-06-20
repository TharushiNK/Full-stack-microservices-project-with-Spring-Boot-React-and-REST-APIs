import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import User from './User';
import Cars from './Car'; // Make sure CarList component is named correctly
import CarForm from './CarForm';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<User />} />  {/* ✅ Login page should be at "/" */}
        <Route path="/CarList" element={<Cars />} /> {/* ✅ Fix incorrect route path */}
        <Route path='/CarForm' element={<CarForm/>}/>
      </Routes>
    </Router>
  );
}

export default App;