import { Button, Container } from "@mui/material";

import {useState, useEffect} from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

function createData(name, calories, fat, carbs, protein) {
  return { name, calories, fat, carbs, protein };
}

const rows = [
  createData('Frozen yoghurt', 159, 6.0, 24, 4.0),
  createData('Ice cream sandwich', 237, 9.0, 37, 4.3),
  createData('Eclair', 262, 16.0, 24, 6.0),
  createData('Cupcake', 305, 3.7, 67, 4.3),
  createData('Gingerbread', 356, 16.0, 49, 3.9),
];

function Home() {
  const [readers, setReaders] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("http://localhost:8080/api/v1/reader", {
      mode: 'cors'
    }).then(res =>{
      if (res.ok) {
        return res.json();
      }
      throw res;
    }).then(data => {
      console.log(data);
      setReaders(data);
    }).catch(error => {
      console.log("Error: ", error);
    }).finally(() => {
      setLoading(false);
    });
  }, []);

  if (loading) return <h1>Loading...</h1>
  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell align="right">ID</TableCell>
            <TableCell align="center">Imię</TableCell>
            <TableCell align="center">Nazwisko</TableCell>
            <TableCell align="right">Numer karty bibliotecznej</TableCell>
            <TableCell align="right"></TableCell>
            <TableCell align="right"></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {readers.map((row) => (
            <TableRow
              key={row.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell align="right">{row[Object.keys(row)[0]]}</TableCell>
              <TableCell align="left">{row[Object.keys(row)[1]]}</TableCell>
              <TableCell align="left">{row[Object.keys(row)[2]]}</TableCell>
              <TableCell align="right">{row[Object.keys(row)[3]]}</TableCell>
              <TableCell align="right">
                <Button>
                  Edytuj
                </Button>
              </TableCell>
              <TableCell align="center">
                <Button>Usuń</Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}


export default Home;