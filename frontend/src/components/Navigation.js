import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Grid from '@mui/material/Grid';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import { Link, useLocation } from "react-router-dom";

const Navigation = () => {
  const tabPaths = ['/authors', '/books', '/copies', '/borrowings', '/readers']

  let location = useLocation();

  const getValue = () => {
    if( tabPaths.includes(location.pathname)){
      switch (location.pathname) {
        case '/authors':
          return 0;
        case '/books':
          return 1;
        case '/copies':
          return 2;
        case '/borrowings':
          return 3;
        case '/readers':
          return 4;
      }   
    }
    return false;
  };

  return (
    <AppBar position="static" color="primary" enableColorOnDark>
      <Container maxWidth="xl">    
            <Box sx={{ flexGrow: 1 }}>
                <Grid container spacing={0} alignItems="center">
                    <Grid item xs="auto" md="auto" sx={{ mr: 5}} >
                      <span>
                        <Box component={Link} to="/" sx={{ flexGrow: 1, display: { xs: 'flex', md: 'flex' }, color: "text.primary", textDecoration: "none"}}>
                            <Typography
                                variant="h6"
                                noWrap               
                                sx={{ ml: 1 }}>
                                Biblioteka
                            </Typography>
                        </Box>
                      </span>
                    </Grid>
                    <Grid item xs={12} sm={12} md="auto" order={{ xs: 3, sm: 3, md: 2 }}>
                      <Tabs indicatorColor="secondary" 
                            textColor="secondary" 
                            variant="fullWidth"
                            value={getValue()}
                            sx={{ mx: 0}}>
                        <Tab label='Autorzy' to='/authors' component={Link} />
                        <Tab label='Książki' to='/books' component={Link} />
                        <Tab label='Egzamplarze' to='/copies' component={Link} />
                        <Tab label='Wypożyczenia' to='/borrowings' component={Link} />
                        <Tab label='Czytelnicy' to='/readers' component={Link} />
                      </Tabs>
                    </Grid>
                    
                </Grid>
            </Box>      
      </Container>
    </AppBar>
  );
};
export default Navigation;