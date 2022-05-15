import { Routes, Route, BrowserRouter} from "react-router-dom";
import Home from "./pages/Home";
import Navigation from "./components/Navigation";
import Borrowings from "./pages/Borrowing/Borrowings";
import AddBorrowing from "./pages/Borrowing/AddBorrowing";
import EditBorrowing from "./pages/Borrowing/EditBorrowing"
import Copies from "./pages/Copy/Copies";
import AddCopy from "./pages/Copy/AddCopy";
import EditCopy from "./pages/Copy/EditCopy"
import Books from "./pages/Book/Books";
import AddBook from "./pages/Book/AddBook";
import EditBook from "./pages/Book/EditBook"
import Authors from "./pages/Author/Authors";
import Readers from "./pages/Reader/Readers";
import AddReader from "./pages/Reader/AddReader";
import EditReader from "./pages/Reader/EditReader";
import AddAuthor from "./pages/Author/AddAuthor";
import EditAuthor from "./pages/Author/EditAuthor"

function App() {
  return (
    <BrowserRouter>
    <Navigation />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/readers" element={<Readers />} />
        <Route path="/reader/add" element={<AddReader />} />
        <Route path="/reader/edit" element={<EditReader />} />
        <Route path="/authors" element={<Authors />} />
        <Route path="/author/add" element={<AddAuthor />} />
        <Route path="/author/edit" element={<EditAuthor />} />
        <Route path="/borrowings" element={<Borrowings />} />
        <Route path="/borrowing/add" element={<AddBorrowing />} />
        <Route path="/borrowing/edit" element={<EditBorrowing />} />
        <Route path="/copies" element={<Copies />} />
        <Route path="/copy/add" element={<AddCopy />} />
        <Route path="/copy/edit" element={<EditCopy />} />
        <Route path="/Books" element={<Books />} />
        <Route path="/book/add" element={<AddBook />} />
        <Route path="/book/edit" element={<EditBook />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
