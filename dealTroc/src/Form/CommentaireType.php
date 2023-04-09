<?php

namespace App\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\Validator\Constraints\Length;
use Symfony\Component\Validator\Constraints\NotBlank;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\DateTimeType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\ButtonType;


class CommentaireType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('commentaire',TextType::class,[
            'label'=>"ecrivez votre commentaire",
            'constraints' => [
                new NotBlank([
                   'message' => 'Veuillez saisir un commentaire'
                ]),
                new Length([
                   'min'=> 5,
                   'max'=> 50,
                   'minMessage'=> 'Votre commentaire doit contenir plus que 5 caractéres methode2 ',
                   'maxMessage'=> 'Votre commentaire a depassé 50 caractéres methode2',
                ])
             ]
            ])
           /* ->add('date', DateTimeType::class, [
                'widget' => 'single_text',
                'html5' => true,
            ])*/
            ->add('save',SubmitType::class,)
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            // Configure your form options here
        ]);
    }
}
