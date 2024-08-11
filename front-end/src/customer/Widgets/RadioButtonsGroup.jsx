import * as React from 'react';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import {useLocation, useNavigate } from 'react-router-dom';

export default function RadioButtonsGroup({ section }) {
    const location = useLocation();
    const navigate = useNavigate();
    function handleRadioFilterChange(e,sectionId)
    {
        const searchParams = new URLSearchParams(location.search);
        searchParams.set(sectionId,e.target.value);
        const query = searchParams.toString();
        navigate({search:`?${query}`})
    }
  return (
    <FormControl component="fieldset" >
      <FormLabel component="legend">{section.title}</FormLabel>
      <RadioGroup
        aria-labelledby={`filter-mobile-${section.id}`}
        defaultValue={section.options.find(option => option.checked)?.value || ""}
        name={section.id}
      >
        {section.options.map((option, optionIdx) => (
          <FormControlLabel
            onChange={(e)=> handleRadioFilterChange(e,section.id) }
            key={option.value}
            value={option.value}
            control={<Radio />}
            label={option.label}
          />
        ))}
      </RadioGroup>
    </FormControl>
  );
}
