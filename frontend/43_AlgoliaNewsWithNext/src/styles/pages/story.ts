import { styled } from '..';

const PageContainer = styled('div', {
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  gap: '1rem',
});

const Form = styled('form', {
  display: 'flex',
  flexDirection: 'column',
  width: '20%',
  gap: '0.5rem',
});

const Label = styled('label', {
  fontWeight: '700',
  fontSize: '$md',
});

const Input = styled('input', {
  borderRadius: '0.5rem',
  fontWeight: '700',
  fontSize: '$md',
  padding: '0.3rem',
});

const Button = styled('button', {
  borderRadius: '0.5rem',
  fontWeight: '700',
  fontSize: '$md',
  backgroundColor: '$green500',
  border: '0',
  transition: 'background-color 0.2s',

  '&:hover': {
    backgroundColor: '$green300',
  },
});

export { PageContainer, Form, Label, Input, Button };
