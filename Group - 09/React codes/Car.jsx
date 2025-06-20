import React, { useEffect, useState } from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useNavigate } from 'react-router-dom';
import AddOutlinedIcon from '@mui/icons-material/AddOutlined';

// Card component for each car
function CarCard({ car, onDelete, onUpdate }) {
  return (
    <Card sx={{ maxWidth: 345, margin: '10px' }}>
      <CardMedia
        component="img"
        height="140"
        image={car.imageUrl || '/static/images/default-car.jpg'}
        alt={car.brand + ' ' + car.model}
      />
      <CardContent>
        <Typography gutterBottom variant="h5">
          {car.brand} {car.model}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          <strong>Price per day:</strong> ${car.price}
        </Typography>
        <Typography variant="body2" color={car.availability ? 'green' : 'red'}>
          <strong>Availability:</strong> {car.availability ? 'Available' : 'Not Available'}
        </Typography>
      </CardContent>
      <CardActions>
        <Button size="small" onClick={() => onUpdate(car.id)}>
          Update
        </Button>
        <Button size="small" color="error" onClick={() => onDelete(car.id)}>
          Delete
        </Button>
      </CardActions>
    </Card>
  );
}

// Main component that fetches and displays cars
export default function CarList() {
  const [cars, setCars] = useState([]);
  const navigate = useNavigate();

  // Fetch car data from REST API
  useEffect(() => {
    async function fetchCars() {
      try {
        const response = await fetch('http://localhost:8080/go-rentals/cars');
        if (!response.ok) {
          throw new Error('Failed to fetch cars');
        }
        const data = await response.json();
        setCars(data); // Assuming API returns an array of car objects
      } catch (error) {
        console.error('Error fetching cars:', error);
      }
    }
    fetchCars();
  }, []);

  // Delete a car from API
  const handleDelete = async (carId) => {
    try {
      const response = await fetch(`http://localhost:8080/go-rentals/cars/${carId}`, {
        method: 'DELETE',
      });
      if (!response.ok) {
        throw new Error('Failed to delete car');
      }
      setCars(cars.filter(car => car.id !== carId)); 
    } catch (error) {
      console.error('Error deleting car:', error);
    }
  };

  // Placeholder update function
  const handleUpdate =  async (carId) => {
    navigate('/CarForm');
  };
  const handleAdd = () =>{
    navigate('/CarForm');
  }

  return (
<div style={{ padding: '20px' }}>  {/* This is the parent container */}
  <Button variant="contained" onClick={handleAdd}>
    Add <AddOutlinedIcon />
  </Button>

  <div style={{ display: 'flex', flexWrap: 'wrap', gap: '20px' }}>
    {cars.map((car) => (
      <div
        key={car.id}
        style={{
          width: 'calc(20% - 16px)',  // Ensures that 5 cards fit per row
          minWidth: '200px', 
          maxWidth:'300px',         // Makes sure cards have a minimum size
          minHeight:'300px',
          maxHeight:'300px',
          height: '300px',            // Sets a height for the card
        }}
      >
        <CarCard car={car} onDelete={handleDelete} onUpdate={handleUpdate} />
      </div>
    ))}
  </div>
</div>

    
  );
}
