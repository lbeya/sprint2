<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20230411104318 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE signaler (id INT AUTO_INCREMENT NOT NULL, commentaire_id INT DEFAULT NULL, user_action INT NOT NULL, user_prop INT NOT NULL, cause VARCHAR(255) NOT NULL, INDEX IDX_EF69B32BA9CD190 (commentaire_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE signaler ADD CONSTRAINT FK_EF69B32BA9CD190 FOREIGN KEY (commentaire_id) REFERENCES commentaire (id)');
        $this->addSql('ALTER TABLE commentaire CHANGE commentaire commentaire VARCHAR(65535) NOT NULL');
        $this->addSql('ALTER TABLE commentaire ADD CONSTRAINT FK_67F068BCEC5FF804 FOREIGN KEY (type_commentaire_id) REFERENCES type_commentaire (id)');
        $this->addSql('CREATE INDEX IDX_67F068BCEC5FF804 ON commentaire (type_commentaire_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE signaler DROP FOREIGN KEY FK_EF69B32BA9CD190');
        $this->addSql('DROP TABLE signaler');
        $this->addSql('ALTER TABLE commentaire DROP FOREIGN KEY FK_67F068BCEC5FF804');
        $this->addSql('DROP INDEX IDX_67F068BCEC5FF804 ON commentaire');
        $this->addSql('ALTER TABLE commentaire CHANGE commentaire commentaire MEDIUMTEXT NOT NULL');
    }
}
