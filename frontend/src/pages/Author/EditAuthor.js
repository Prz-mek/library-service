import React from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { useState, useEffect, useCallback } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import "../../index.css";

const apiAddress = "http://localhost:8080/api/v1/author";

export default function EditAuthor() {
    const location = useLocation();
    const { id } = location.state;

    const navigate = useNavigate();
    const handleReturn = useCallback(() => navigate('/authors', { replace: true }), [navigate]);

    const [author, setAuthor] = useState(null);
    const [isError, setIsError] = useState(false);
    const [loading, setLoading] = useState(true);

    const loadData = () => {
        fetch(`${apiAddress}/${id}`, {
            mode: 'cors'
        }).then(res => {
            if (res.ok) {
                return res.json();
            }
            throw res;
        }).then(data => {
            setAuthor(data);
        }).catch(error => {
            console.log("Error: ", error);
            setIsError(true);
        }).finally(() => {
            setLoading(false);
        });
    };

    useEffect(loadData, []);

    function submitHandler(event) {
        event.preventDefault();
        const data = new FormData(event.currentTarget);
        const author = {
            firstName: data.get("firstName"),
            lastName: data.get("lastName")
        }
        fetch(`${apiAddress}/${id}`, {
            method: 'PUT',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(author)
        }).then(res => {
            if (res.ok) {
                handleReturn();
            } else {
                console.log(res.ok);
                throw res;
            }
        }).catch(error => {
            alert("Wyst??pi?? b????d!");
        })
    }

    if (loading) return <h1>Loading...</h1>
    if (isError) return <h1>Error!</h1>
    return (
        <div className="login">
            <Container component="main" maxWidth="sm">
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
                        Aktualizacja autora
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
                                    label="Imi??"
                                    name="firstName"
                                    autoComplete="firstName"
                                    autoFocus
                                    color="secondary"
                                    defaultValue={author.firstName}
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
                                    defaultValue={author.lastName}
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
                            Zapisz zmiany
                        </Button>
                    </Box>
                </Box>
            </Container>
        </div>
    );
}