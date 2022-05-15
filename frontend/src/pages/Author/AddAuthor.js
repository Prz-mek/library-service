import React from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import { Link } from "react-router-dom";
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import "../../index.css";

const apiAddress = "http://localhost:8080/api/v1/author";

export default function AddAuthor() {

  function submitHandler(event) {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    const author = {
      firstName: data.get("firstName"),
      lastName: data.get("lastName")
    }
    fetch(apiAddress, {
      method: 'POST',
      mode: 'cors',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(author)
    }).then(res => console.log(res))
  }

  return (
    <div className="login">
      <Container component="main" maxWidth="sm">
        <Link to="/authors">Powrót</Link>
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
            Dodaj autora
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
            </Grid>
            
            <Button
                type="submit"
                fullWidth
                size="large"
                variant="contained"
                color="secondary"
                sx={{ mt: 3, mb: 2 }}
              >
                Dodaj
              </Button>
          </Box>
        </Box>
      </Container>
    </div>
  );
}