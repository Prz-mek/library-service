import { Routes, Route, BrowserRouter} from "react-router-dom";
import Home from "./pages/Home";
import Navigation from "./components/Navigation";
import Borrowings from "./pages/Borrowings";
import Copies from "./pages/Copies";
import Books from "./pages/Books";
import Authors from "./pages/Authors";
import Readers from "./pages/Readers";

function App() {
  return (
    <BrowserRouter>
    <Navigation />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/readers" element={<Readers />} />
        <Route path="/authors" element={<Authors />} />
        <Route path="/borrowings" element={<Borrowings />} />
        <Route path="/copies" element={<Copies />} />
        <Route path="/Books" element={<Books />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
