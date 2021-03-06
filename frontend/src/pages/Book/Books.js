import { Button, Container, TextField } from "@mui/material";
import { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

import * as XLSX from "xlsx";


const apiAddress = "http://localhost:8080/api/v1/book";

function Books() {
    const [books, setBooks] = useState(null);
    const [isError, setIsError] = useState(false);
    const [loading, setLoading] = useState(true);
    const [searchedTitle, setSearchedTitle] = useState("");

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

    function deleteHandler(id) {
        fetch(apiAddress + "/" + id, {
            method: 'DELETE',
            mode: 'cors'
        }).finally(() => {
            setLoading(true);
            setBooks(null);
        })
    }

    const requestSearchTitle = (searchedVal) => {
        console.log(searchedVal)
        const filteredRows = books.filter((row) => {
            return row.title.toLowerCase().includes(searchedVal.toLowerCase());
        });
        setSearchedTitle(searchedVal);
        setBooks(filteredRows);
    };

    if (loading) return <h1>Loading...</h1>
    if (isError) return <h1>Error!</h1>
    return (
        <Container>
            <Link to="/book/add">
                <Button>Dodaj</Button>
            </Link>

            <Link to="/books/report">
                <Button>Zobacz raport</Button>
            </Link>

            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell align="right">ID</TableCell>
                            <TableCell align="center">ISBN</TableCell>
                            <TableCell align="center">Tytu??<br />
                                <TextField
                                    value={searchedTitle}
                                    onChange={e => requestSearchTitle(e.target.value)}
                                /></TableCell>
                            <TableCell align="center">ID autora</TableCell>
                            <TableCell align="center">Gatunek</TableCell>
                            <TableCell align="right"></TableCell>
                            <TableCell align="right"></TableCell>
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
                                <TableCell align="right">
                                    <Link to="/book/edit" state={{ id: row.id }}>
                                        <Button>
                                            Edytuj
                                        </Button>
                                    </Link>
                                </TableCell>
                                <TableCell align="center">
                                    <Button onClick={() => deleteHandler(row.id)}>Usu??</Button>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Container>
    );
}

export default Books;


// 

// downloadExcel = (data) => {
//     const worksheet = XLSX.utils.json_to_sheet(data);
//     const workbook = XLSX.utils.book_new();
//     XLSX.utils.book_append_sheet(workbook, worksheet, "Sheet1");
//     //let buffer = XLSX.write(workbook, { bookType: "xlsx", type: "buffer" });
//     //XLSX.write(workbook, { bookType: "xlsx", type: "binary" });
//     XLSX.writeFile(workbook, "DataSheet.xlsx");
//   };
