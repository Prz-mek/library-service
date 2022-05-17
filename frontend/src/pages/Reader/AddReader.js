import React from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import { Link } from "react-router-dom";
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import "../../index.css";

const apiAddress = "http://localhost:8080/api/v1/reader";

export default function AddReader() {

  function submitHandler(event) {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    const reader = {
      firstName: data.get("firstName"),
      lastName: data.get("lastName"),
      email: data.get("email"),
      libraryCardNumber: data.get("libraryCardNumber")
    }

    if (reader.firstName == "" || reader.lastName == "" || reader.email == "") {
      alert("Nie podano wszystkich wymaganych danych!");
      return;
    }

    fetch(apiAddress, {
      method: 'POST',
      mode: 'cors',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(reader)
    }).then(res => console.log(res))
  }

  return (
    <div className="login">
      <Container component="main" maxWidth="sm">
        <Link to="/readers">Powrót</Link>
        <Box sx={{ p: { xs: 4, sm: 6, md: 6 } }}></Box>
        <Box
          sx={{
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            backgroundColor: "primary.main",
            p: 5,
            borderRadius: "12px",
            boxShadow: 2,
            mb: { xs: 8, sm: 12, md: 16 },
          }}
        >
          <Typography component="h1" variant="h5">
            Rejestracja czytelnika
          </Typography>
          <Box
            component="form"
            noValidate
            onSubmit={submitHandler}
            sx={{ mt: 3 }}
          >
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="firstName"
                  label="Imię"
                  name="firstName"
                  autoComplete="firstName"
                  autoFocus
                  color="secondary"
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="lastName"
                  label="Nazwisko"
                  name="lastName"
                  autoComplete="lastName"
                  autoFocus
                  color="secondary"
                />
              </Grid>
              <Grid item xs={12}>
                    <TextField
                      required
                      fullWidth
                      id="email"
                      label="Adres e-mail"
                      name="email"
                      autoComplete="email"
                      autoFocus
                      color="secondary"
                    />
                  </Grid>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  name="libraryCardNumber"
                  label="Numer karty bibliotecznej"
                  id="libraryCardNumber"
                  autoComplete="libraryCardNumber"
                  autoFocus
                  color="secondary"
                />
              </Grid>
            </Grid>
            
            <Button
                type="submit"
                fullWidth
                size="large"
                variant="contained"
                color="secondary"
                sx={{ mt: 3, mb: 2 }}
              >
                Zarejestruj czytelnika
              </Button>
          </Box>
        </Box>
      </Container>
    </div>
  );
}