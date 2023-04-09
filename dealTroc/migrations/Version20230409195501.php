<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20230409195501 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE type_commentaire (id INT AUTO_INCREMENT NOT NULL, libelle VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE messenger_messages (id BIGINT AUTO_INCREMENT NOT NULL, body LONGTEXT NOT NULL, headers LONGTEXT NOT NULL, queue_name VARCHAR(190) NOT NULL, created_at DATETIME NOT NULL, available_at DATETIME NOT NULL, delivered_at DATETIME DEFAULT NULL, INDEX IDX_75EA56E0FB7336F0 (queue_name), INDEX IDX_75EA56E0E3BD61CE (available_at), INDEX IDX_75EA56E016BA31DB (delivered_at), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('DROP TABLE produit');
        $this->addSql('DROP TABLE utilisateur');
        $this->addSql('DROP INDEX addCommentaire ON commentaire');
        $this->addSql('ALTER TABLE commentaire ADD type_commentaire_id INT NOT NULL, CHANGE commentaire commentaire VARCHAR(65535) NOT NULL, CHANGE Date date DATETIME NOT NULL, CHANGE type type VARCHAR(65535) NOT NULL');
        $this->addSql('ALTER TABLE commentaire ADD CONSTRAINT FK_67F068BCEC5FF804 FOREIGN KEY (type_commentaire_id) REFERENCES type_commentaire (id)');
        $this->addSql('CREATE INDEX IDX_67F068BCEC5FF804 ON commentaire (type_commentaire_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE commentaire DROP FOREIGN KEY FK_67F068BCEC5FF804');
        $this->addSql('CREATE TABLE produit (IdProduit INT AUTO_INCREMENT NOT NULL, iduser INT NOT NULL, PRIMARY KEY(IdProduit)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('CREATE TABLE utilisateur (Id_utilisateur INT AUTO_INCREMENT NOT NULL, nom VARCHAR(30) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, email TEXT CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_general_ci`, PRIMARY KEY(Id_utilisateur)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_general_ci` ENGINE = InnoDB COMMENT = \'\' ');
        $this->addSql('DROP TABLE type_commentaire');
        $this->addSql('DROP TABLE messenger_messages');
        $this->addSql('DROP INDEX IDX_67F068BCEC5FF804 ON commentaire');
        $this->addSql('ALTER TABLE commentaire DROP type_commentaire_id, CHANGE commentaire commentaire TEXT NOT NULL, CHANGE date Date DATE NOT NULL, CHANGE type type TEXT NOT NULL');
        $this->addSql('CREATE INDEX addCommentaire ON commentaire (id_utilisateur)');
    }
}
