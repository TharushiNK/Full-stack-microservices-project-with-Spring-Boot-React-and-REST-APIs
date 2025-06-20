import React,{useState} from "react";
import {Container, TextField, Button } from "@mui/material";
import AddOutlinedIcon from '@mui/icons-material/AddOutlined';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';

export default function CarForm(){
    const [brand, setBrand] = useState('');
    const [model, setModel] = useState('');
    const [availability, setAvailability] = useState('');
    const [price, setPrice] = useState('');
    const [message, setMessage] = useState('');

    const handleAdd = async(e) =>{
        e.preventDefault();
        const car ={brand, model, availability, price}
        try{
            const response = await fetch ('http://localhost:8080/go-rentals/cars',{
                method :'POST',
                headers : {"Content-type":"application/json"},
                body: JSON.stringify(car),
            
            })
            if(response.ok){
                setMessage("New car added successfully");
            }
            else{
                setMessage("Request failed")
            }
        }
        catch(error){
            console.log(error);
            setMessage('Car adding unsuccessful',error);
            

        }

    }


    return(

        <Container>
            <TextField
            id="brand"
            label= "Brand"
            variant="filled"
            value={brand}
            onChange ={(e) => setBrand(e.target.value)}
            />
            <TextField
            id ="model"
            label="Model"
            variant="filled"
            value={model}
            onChange ={(e) => setModel(e.target.value)} 
            />
            <TextField
            id="price"
            label="Price per Day"
            value={price}
            onChange ={(e) => setPrice(e.target.value)}
            /><br></br>
        <FormGroup>
            <FormControlLabel control={<Checkbox defaultChecked />} label="Availability"  onChange={(e) => setAvailability(e.target.checked ? 1 : 0)} required/>

        </FormGroup>
           
            
        <Button variant="contained" onClick={handleAdd} ><AddOutlinedIcon /> Add Car </Button>
        {message && <p>{message}</p>}


        </Container>        

        

        

    );
}
