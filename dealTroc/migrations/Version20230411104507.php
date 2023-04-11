<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20230411104507 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE commentaire CHANGE commentaire commentaire VARCHAR(65535) NOT NULL');
        $this->addSql('ALTER TABLE commentaire ADD CONSTRAINT FK_67F068BCEC5FF804 FOREIGN KEY (type_commentaire_id) REFERENCES type_commentaire (id)');
        $this->addSql('CREATE INDEX IDX_67F068BCEC5FF804 ON commentaire (type_commentaire_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE commentaire DROP FOREIGN KEY FK_67F068BCEC5FF804');
        $this->addSql('DROP INDEX IDX_67F068BCEC5FF804 ON commentaire');
        $this->addSql('ALTER TABLE commentaire CHANGE commentaire commentaire MEDIUMTEXT NOT NULL');
    }
}
