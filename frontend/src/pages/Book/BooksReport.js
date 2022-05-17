import { Button, Container, TextField } from "@mui/material";
import { useState, useEffect } from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

import * as XLSX from "xlsx";


const apiAddress = "http://localhost:8080/api/v1/book/report";

function Books() {
    const [books, setBooks] = useState(null);
    const [isError, setIsError] = useState(false);
    const [loading, setLoading] = useState(true);
    const [searchedTitle, setSearchedTitle] = useState("");
    const [searchedAuthor, setSearchedAuthor] = useState("");
    const [searchedGenre, setSearchedGenre] = useState("");
    const [searchedCopies, setSearchedCopies] = useState(0);
    const [searchedBorrowings, setSearchedBorrowings] = useState(0);

    const loadData = () => {
        fetch(apiAddress, {
            mode: 'cors'
        }).then(res => {
            if (res.ok) {
                return res.json();
            }
            throw res;
        }).then(data => {
            console.log(data);
            setBooks(data);
        }).catch(error => {
            console.log("Error: ", error);
            setIsError(true);
        }).finally(() => {
            setLoading(false);
        });
    };

    const downloadExcel = (data) => {
    const worksheet = XLSX.utils.json_to_sheet(data);
    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, "Sheet1");
    XLSX.writeFile(workbook, "DataSheet.xlsx");
  };

    useEffect(loadData, []);

    const requestSearchTitle = (searchedVal) => {
        console.log(searchedVal)
        const filteredRows = books.filter((row) => {
            return row.title.toLowerCase().includes(searchedVal.toLowerCase());
        });
        setSearchedTitle(searchedVal);
        setBooks(filteredRows);
    };

    const requestSearchAuthor = (searchedVal) => {
        console.log(searchedVal)
        const filteredRows = books.filter((row) => {
            return row.title.toLowerCase().includes(searchedVal.toLowerCase());
        });
        setSearchedAuthor(searchedVal);
        setBooks(filteredRows);
    };

    const requestSearchGenre = (searchedVal) => {
        console.log(searchedVal)
        const filteredRows = books.filter((row) => {
            return row.genre.toLowerCase().includes(searchedVal.toLowerCase());
        });
        setSearchedGenre(searchedVal);
        setBooks(filteredRows);
    };

    const requestSearchCopies = (searchedVal) => {
        console.log(searchedVal)
        const filteredRows = books.filter((row) => {
            return row.copiesCount > searchedVal;
        });
        setSearchedCopies(searchedVal);
        setBooks(filteredRows);
    };

    const requestSearchBorrowings = (searchedVal) => {
        console.log(searchedVal)
        const filteredRows = books.filter((row) => {
            return row.borrowingsCount > searchedVal;
        });
        setSearchedBorrowings(searchedVal);
        setBooks(filteredRows);
    };


    if (loading) return <h1>Loading...</h1>
    if (isError) return <h1>Error!</h1>
    return (
        <Container>

            <Button onClick={() => downloadExcel(books)}>
                Pobierz plik Excel
            </Button>

            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell align="right">ID</TableCell>
                            <TableCell align="center">ISBN</TableCell>
                            <TableCell align="center">Tytuł<br />
                                <TextField
                                    value={searchedTitle}
                                    onChange={e => requestSearchTitle(e.target.value)}
                                /></TableCell>
                            <TableCell align="center">ID autora</TableCell>
                            <TableCell align="center">Nazwisko autora<br />
                                <TextField
                                    value={searchedAuthor}
                                    onChange={e => requestSearchAuthor(e.target.value)}
                                /></TableCell>
                            <TableCell align="center">Gatunek<br />
                                <TextField
                                    value={searchedGenre}
                                    onChange={e => requestSearchGenre(e.target.value)}
                                /></TableCell>
                            <TableCell align="right">Liczba kopii<TextField
                                    value={searchedCopies}
                                    onChange={e => requestSearchCopies(e.target.value)}
                                /></TableCell>
                            <TableCell align="right">Liczba wyporzyczeń<TextField
                                    value={searchedBorrowings}
                                    onChange={e => requestSearchBorrowings(e.target.value)}
                                />
                            </TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {books.map((row) => (
                            <TableRow
                                key={row.id}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell align="right">{row[Object.keys(row)[0]]}</TableCell>
                                <TableCell align="left">{row[Object.keys(row)[1]]}</TableCell>
                                <TableCell align="left">{row[Object.keys(row)[2]]}</TableCell>
                                <TableCell align="right">{row[Object.keys(row)[3]]}</TableCell>
                                <TableCell align="left">{row[Object.keys(row)[4]]}</TableCell>
                                <TableCell align="left">{row[Object.keys(row)[5]]}</TableCell>
                                <TableCell align="left">{row[Object.keys(row)[6]]}</TableCell>
                                <TableCell align="left">{row[Object.keys(row)[7]]}</TableCell>
                                
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Container>
    );
}

export default Books;