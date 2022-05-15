import { Button, Container } from "@mui/material";
import { useState, useEffect} from 'react';
import { Link } from "react-router-dom";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

const apiAddress = "http://localhost:8080/api/v1/copy";

function Copies() {
    const [copies, setCopies] = useState(null);
    const [isError, setIsError] = useState(false);
    const [loading, setLoading] = useState(true);

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
            setCopies(data);
        }).catch(error => {
            console.log("Error: ", error);
            setIsError(true);
        }).finally(() => {
            setLoading(false);
        });
    };

    useEffect(loadData, []);

    function deleteHandler(id) {
        fetch(apiAddress + "/" + id, {
          method: 'DELETE',
          mode: 'cors'
        }).finally(() => {
            setLoading(true);
            setCopies(null);
        })
    }

    if (loading) return <h1>Loading...</h1>
    if (isError) return <h1>Error!</h1>
    return (
        <Container>
            <Link to="/copy/add">
                <Button>Dodaj</Button>
            </Link>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell align="right">ID</TableCell>
                            <TableCell align="right">ID książki</TableCell>
                            <TableCell align="right"></TableCell>
                            <TableCell align="right"></TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {copies.map((row) => (
                            <TableRow
                                key={row.id}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell align="right">{row[Object.keys(row)[0]]}</TableCell>
                                <TableCell align="right">{row[Object.keys(row)[1]]}</TableCell>
                                <TableCell align="right">
                                    <Link to="/copy/edit" state={{ id: row.id }}>
                                        <Button>
                                            Edytuj
                                        </Button>
                                    </Link>
                                </TableCell>
                                <TableCell align="center">
                                    <Button onClick={() => deleteHandler(row.id)}>Usuń</Button>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Container>
    );
}

export default Copies;