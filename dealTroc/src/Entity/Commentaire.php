<?php

namespace App\Entity;

use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use App\Repository\CommentaireRepository;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity(repositoryClass="App\Repository\CommentaireRepository")
 */

#[ORM\Entity(repositoryClass: CommentaireRepository::class)]

class Commentaire
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;


    #[ORM\Column(length: 65535)]
    /*#[Assert\NotBlank(message:"le champ est vide")]
    #[Assert\Length(
        min: 5,
        max: 50,
        minMessage: 'Votre commentaire doit contenir plus que 5 caractéres ',
        maxMessage: 'Votre commentaire a depassé 50 caractéres',
    )]*/
    private ?string $commentaire = null;

    #[ORM\Column]
   // #[Assert\NotBlank(message:"le champ est vide")]
    private ?int $idUtilisateur = null;

  
    #[ORM\Column(type: Types::DATETIME_MUTABLE)]
    private ?\DateTimeInterface $date = null;
    
    #[ORM\Column]
    private ?int $idproduit = null;

    #[ORM\ManyToOne(inversedBy: 'commentaires')]
    #[ORM\JoinColumn(nullable: false)]
    private ?TypeCommentaire $typeCommentaire = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getCommentaire(): ?string
    {
        return $this->commentaire;
    }

    public function setCommentaire(string $commentaire): self
    {
        $this->commentaire = $commentaire;

        return $this;
    }

    public function getIdUtilisateur(): ?int
    {
        return $this->idUtilisateur;
    }

    public function setIdUtilisateur(int $idUtilisateur): self
    {
        $this->idUtilisateur = $idUtilisateur;

        return $this;
    }

    public function getDate(): ?\DateTimeInterface
    {
        return $this->date;
    }

    public function setDate(\DateTimeInterface $date): self
    {
        $this->date = $date;

        return $this;
    }

    public function getIdproduit(): ?int
    {
        return $this->idproduit;
    }

    public function setIdproduit(int $idproduit): self
    {
        $this->idproduit = $idproduit;

        return $this;
    }

    public function getTypeCommentaire(): ?TypeCommentaire
    {
        return $this->typeCommentaire;
    }

    public function setTypeCommentaire(?TypeCommentaire $typeCommentaire): self
    {
        $this->typeCommentaire = $typeCommentaire;

        return $this;
    }


}
